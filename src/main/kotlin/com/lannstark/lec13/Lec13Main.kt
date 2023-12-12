package com.lannstark.lec13


fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom,
) {
    class LivingRoom(
        private val area: Double
    )

    inner class InnerLivingRoom() {
        fun getHouseAddress(): String {
            return this@House.address
        }
    }
}