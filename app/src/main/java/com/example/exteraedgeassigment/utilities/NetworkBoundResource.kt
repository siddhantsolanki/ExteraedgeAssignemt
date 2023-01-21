package com.example.exteraedgeassigment.utilities

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(

   crossinline query: () -> Flow<ResultType>,
   crossinline fetch: suspend () -> RequestType,
   crossinline saveFetchResult: suspend (RequestType) -> Unit,
   crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(DomainResult.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map{ DomainResult.Success(it)}
        }catch (throwable: Throwable){
            query().map { DomainResult.Error(throwable,it) }
        }
    }else{
        query().map { DomainResult.Success(it) }
    }
    emitAll(flow)
}