package by.vashkevich.lesson1hw.HW8.data.dto.cryptocurrency

//, alternate = ["1027", "52","1839","2010","74","825","6636","8916","1831","7083","2","1975","521","3408","1321","3077","5426","1765","3890","2416","1956","3717","2280","4687","329","7278","1376","5994","3602","4256","4172","2502","3794","2011","1720","4195","5034","5805","7186","1518","4943","4030","4154","3635","3718","5692","131","1274","1437","3957","6892","873","4023","4066","4642","5864","6535","1168","2586","6758","2469","1684","7129","2135","2694","2394","1966","3894","2682","4847","2083","1697","6719","2566","2130","3822","2700","3513","109","5617","1567","1698","1042","1727","1808","1896","3945","2577","2099","6538","5665","3330","7064","7288","2499","2563","5567","3964","3783","1839"]

import com.google.gson.annotations.SerializedName

data class CryptoLogoResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Status?
) {
    data class Data(
        @SerializedName("1",alternate =["52"])
        val x1: X1?
    ) {
        data class X1(
            @SerializedName("category")
            val category: String?,
            @SerializedName("date_added")
            val dateAdded: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("is_hidden")
            val isHidden: Int?,
            @SerializedName("logo")
            val logo: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("notice")
            val notice: String?,
            @SerializedName("platform")
            val platform: Any?,
            @SerializedName("slug")
            val slug: String?,
            @SerializedName("subreddit")
            val subreddit: String?,
            @SerializedName("symbol")
            val symbol: String?,
            @SerializedName("tag-groups")
            val tagGroups: List<String?>?,
            @SerializedName("tag-names")
            val tagNames: List<String?>?,
            @SerializedName("tags")
            val tags: List<String?>?,
            @SerializedName("twitter_username")
            val twitterUsername: String?,
            @SerializedName("urls")
            val urls: Urls?
        ) {
            data class Urls(
                @SerializedName("announcement")
                val announcement: List<Any?>?,
                @SerializedName("chat")
                val chat: List<Any?>?,
                @SerializedName("explorer")
                val explorer: List<String?>?,
                @SerializedName("message_board")
                val messageBoard: List<String?>?,
                @SerializedName("reddit")
                val reddit: List<String?>?,
                @SerializedName("source_code")
                val sourceCode: List<String?>?,
                @SerializedName("technical_doc")
                val technicalDoc: List<String?>?,
                @SerializedName("twitter")
                val twitter: List<Any?>?,
                @SerializedName("website")
                val website: List<String?>?
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int?,
        @SerializedName("elapsed")
        val elapsed: Int?,
        @SerializedName("error_code")
        val errorCode: Int?,
        @SerializedName("error_message")
        val errorMessage: Any?,
        @SerializedName("notice")
        val notice: Any?,
        @SerializedName("timestamp")
        val timestamp: String?
    )
}