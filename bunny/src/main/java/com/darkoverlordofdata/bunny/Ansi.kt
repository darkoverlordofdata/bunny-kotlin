package com.darkoverlordofdata.bunny

enum class Effect {
    RESET,
    BRIGHT,
    DIM,
    UNDERLINE,
    BLINK,
    REVERSE,
    HIDDEN
}

enum class Color {
    BLACK,
    RED,
    GREEN,
    YELLOW,
    BLUE,
    MAGENTA,
    CYAN,
    WHITE
}


class Ansi {

    companion object Static {
        fun reset(): String {
            return "\u001b[0m";
        }

        fun effect(effect: Effect): String {
            return "\u001b[${effect}m";
        }

        fun foreground(color: Color): String {
            return "\u001b[${color.ordinal+30}m";
        }

        fun background(color: Color): String {
            return "\u001b[${color.ordinal + 40}m";
        }

        fun style(effect: Effect, foreground: Color, background: Color): String {
            return "\u001b[$effect;${foreground.ordinal + 30};${background.ordinal + 40}m"
        }
    }
}