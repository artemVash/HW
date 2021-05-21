package by.vashkevich.lesson1hw.HW8.data.entities.cryptocurrency

data class CryptoRate(
    val id: Int,
    val name: String,
    val symbol: String,
    val lastUpdated: String,
    val percentChange1h: Double,
    val price: Double,
)
