package com.daniel.core.exception

class NewsAppCustomException(
    exceptionMessage: String? = "Exception message is empty",
    cause: Throwable? = null
) :
    Exception(exceptionMessage, cause) {

}

