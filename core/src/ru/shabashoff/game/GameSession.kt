package ru.shabashoff.game

import com.badlogic.gdx.graphics.Color
import ru.shabashoff.game.players.*
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.LineType
import ru.shabashoff.primitives.MoveTo
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.TextLabel
import java.lang.IllegalStateException
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class GameSession(val initPlayers: List<InitPlayer>) {

    private lateinit var text: TextLabel
    private val W = 7
    private val H = 7

    private val paddingX: Float = UiUtils.calcWidth(0.25f)
    private val paddingY: Float = UiUtils.calcHeight(0.15f)

    private val widthMap: Float = UiUtils.calcWidth(0.5f)
    private val heightMap: Float = UiUtils.calcHeight(0.8f)

    val map: GameMap = GameMap(10, W, H, widthMap, heightMap, paddingX, paddingY)

    private var players: MutableList<Player> = ArrayList()
    private lateinit var curPlayer: Player

    private var curNumPlayer: Int = 0

    private var gameMode: GameMode = GameMode.FIRST

    private val reachableCells: MutableSet<GameCell> = HashSet()

    private var executor: Executor = Executors.newSingleThreadExecutor()

    init {
        map.checkConstraints()
    }

    fun dispose() {
        players.forEach { p -> p.remove() }
        map.dispose()
    }

    fun loadPlayers() {
        for (ip in initPlayers) {
            if (ip.playerType == PlayerType.BOT) {
                players.add(Bot(ip, map.getGift()))
            } else {
                players.add(RealPlayer(ip, map.getGift()))
            }
        }

        curPlayer = players[0]

    }


    fun onClick(cell: GameCell) {
        println("Onclick sell:$cell")
        if (curPlayer.isBot()) return

        clickWithPermission(cell)
    }

    fun onDrag(cell: GameCell, x: Float, y: Float) {
        if (curPlayer.isBot() || gameMode == GameMode.SECOND) return

        map.onDrag(cell, x, y)
    }

    fun onPut(cell: GameCell) {
        if (curPlayer.isBot()) return

        putWithPermission(cell)
    }

    private fun putWithPermission(cell: GameCell) {
        if (gameMode == GameMode.SECOND) return

        val onPut = map.onPut(cell)
        if (onPut != null) {
            for (player in players) {
                when {
                    onPut.type == LineType.Y && onPut.line == player.curPoint.y -> player.moveBy(IntPoint(if (onPut.moveTo == MoveTo.RIGHT) 1 else -1, 0))
                    onPut.type == LineType.X && onPut.line == player.curPoint.x -> player.moveBy(IntPoint(0, if (onPut.moveTo == MoveTo.UP) 1 else -1))
                }
            }

            afterPut()
        }
    }

    private fun clickWithPermission(cell: GameCell) {
        if (gameMode == GameMode.FIRST || reachableCells.contains(cell).not()) return

        map.checkConstraints()

        val point = cell.getCenter()

        curPlayer.move(IntPoint(map.deConvertX(point.x), map.deConvertY(point.y)))

        gameMode = GameMode.FIRST
        nextPlayer()
        map.onClick(cell)
    }

    private fun afterPut() {
        reachableCells.clear()
        fillReachableCells(map.getCell(curPlayer.curPoint))
        print(reachableCells)

        gameMode = GameMode.SECOND
    }

    private fun fillReachableCells(cell: GameCell?) {
        if (cell == null || reachableCells.contains(cell)) return

        reachableCells.add(cell)

        if (cell.type.bottom) {
            val cl = map.getCell(cell.getIp().add(IntPoint(0, -1)))
            if (cl != null && cl.type.up) fillReachableCells(cl)
        }
        if (cell.type.up) {
            val cl = map.getCell(cell.getIp().add(IntPoint(0, 1)))
            if (cl != null && cl.type.bottom) fillReachableCells(cl)
        }
        if (cell.type.left) {
            val cl = map.getCell(cell.getIp().add(IntPoint(-1, 0)))
            if (cl != null && cl.type.right) fillReachableCells(cl)
        }
        if (cell.type.right) {
            val cl = map.getCell(cell.getIp().add(IntPoint(1, 0)))
            if (cl != null && cl.type.left) fillReachableCells(cl)
        }
    }

    fun giftFounded() {
        curPlayer.searchingGift = map.getGift()//TODO next gift
    }

    private fun nextPlayer() {
        curNumPlayer = (curNumPlayer + 1) % players.size
        curPlayer = players[curNumPlayer]


        text = TextLabel(0.45f,0.10f, "${curPlayer.playerInit.name} move", Color.WHITE)
        if (curPlayer.isBot()) {
            executor.execute {
                val bot: Bot = curPlayer as Bot
                println("Bot prepare fields")
                Thread.sleep(500)
                bot.prepareMove()
                println("Bot thinking")
                Thread.sleep(500)

                val ptp = bot.getPointToPut()
                println("Bot did first choose. Move cell to $ptp")
                putWithPermission(map.getCell(ptp)!!)
                Thread.sleep(500)

                val ptm = bot.getPointToPut()
                println("Bot did second choose. Going to $ptm")
                clickWithPermission(map.getCell(bot.getPointToMove())!!)
                Thread.sleep(500)

                map.checkConstraints()

                println("Bot is done!")

                if (curPlayer == bot) {
                    throw IllegalStateException("Bot did illegal move!!!")
                }
            }
            println("Bot moved!!!")
        }
    }

    enum class GameMode {
        FIRST, SECOND
    }
}
