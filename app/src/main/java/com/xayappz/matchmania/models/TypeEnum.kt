package com.xayappz.matchmania.models

enum class SportType(var type: Int) {
    CRICKET(4),
    TENNIS(2),
    SOCCER(1)
}

enum class Timeline(var type: String) {
    Today("Today"),
    Tomorrow("Tomorrow"),
    InPlay("Inplay"),
    Result("Result")

}