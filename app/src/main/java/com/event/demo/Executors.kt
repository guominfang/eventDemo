package com.event.demo

import java.util.concurrent.Executors

/**
 * @author gmf
 * @description
 * @date 2022/5/8.
 */
private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}