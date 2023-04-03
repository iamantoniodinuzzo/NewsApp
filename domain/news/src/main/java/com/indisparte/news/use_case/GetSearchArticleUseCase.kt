package com.indisparte.news.use_case

import com.indisparte.common_utils.Resources
import com.indisparte.news.model.Article
import com.indisparte.news.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


private val TAG = GetSearchArticleUseCase::class.simpleName

/**
 * @author Antonio Di Nuzzo (Indisparte)
 */
class GetSearchArticleUseCase(private val searchRepository: SearchRepository) {

    operator fun invoke(map: MutableMap<String, String>): Flow<Resources<List<Article>>> = flow {
        emit(Resources.Loading())
        try {
            emit(Resources.Success(searchRepository.getSearchArticles(map)))
        } catch (e: Exception) {
            emit(Resources.Error(e.message.toString()))
        }
    }
}