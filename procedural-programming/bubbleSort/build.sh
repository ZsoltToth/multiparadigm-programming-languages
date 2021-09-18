#!/usr/bin/env bash
gcc_otions=()
gcc_otions+=(-o main.o)
gcc_otions+=(-Wall)
#gcc_otions+=(-Werror)
# shellcheck disable=SC2068
gcc ${gcc_otions[@]} *.c