package com.example.exteraedgeassigment.utilities

sealed class DomainResult<T>(val data: T?) {
    class Success<T>(data: T): DomainResult<T>(data)
    class Loading<T>(data: T?= null): DomainResult<T>(data)
    class Error<T>(throwable: Throwable,data: T? = null): DomainResult<T>(data)
}