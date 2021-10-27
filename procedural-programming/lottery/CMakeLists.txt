cmake_minimum_required(VERSION 3.20)
project(lottery C)

set(CMAKE_C_STANDARD 11)

add_executable(lottery main.c lottery.h lottery.c)

