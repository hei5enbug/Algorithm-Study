fun main() {
    val genres = arrayOf("classic", "pop", "classic", "classic")
    val plays = intArrayOf(500, 600, 150, 800)
    BestElbum().solution(genres, plays)
}

class BestElbum {

    class Genre(
        var allCount: Int = 0,
        val songList: ArrayList<Song>
    )

    class Song(
        val songId: Int,
        val count: Int = 0
    )

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = arrayListOf<Int>()

        val genreMap = hashMapOf<String, Genre>()

        for (id in plays.indices) {
            val songCount = plays[id]
            val genre = genres[id]

            val song = Song(id, songCount)

            if (genreMap.contains(genre)) {
                genreMap[genre]!!.allCount += songCount
                genreMap[genre]!!.songList.add(song)
            } else {
                genreMap[genre] = Genre(songCount, arrayListOf(song))
            }
        }

        genreMap.values
            .sortedByDescending { it.allCount }
            .map { genre ->
                val songList = genre.songList.sortedByDescending { it.count }
                answer.add(songList[0].songId)
                if (songList.size >= 2) {
                    answer.add(songList[1].songId)
                }
            }

        return answer.toIntArray()
    }
}