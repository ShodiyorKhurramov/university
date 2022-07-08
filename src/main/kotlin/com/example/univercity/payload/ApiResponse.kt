package com.example.univercity.payload

class ApiResponse(val message: String?, val success: Boolean, val id: Any?, val status: Any?) {
    constructor(message: String?, success: Boolean, status: Any?) : this(message, success, null, status)

}
