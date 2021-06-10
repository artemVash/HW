package by.vashkevich.lesson1hw.HW11.data.mapper

interface Mapper<T,F> {

    fun map(from: T):F

}