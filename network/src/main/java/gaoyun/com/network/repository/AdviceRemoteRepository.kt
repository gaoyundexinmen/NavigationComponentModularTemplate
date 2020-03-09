package gaoyun.com.network.repository

import gaoyun.com.network.AdviceService
import gaoyun.com.network.responses.AdviceObject
import io.reactivex.Single

interface AdviceRemoteRepository {
    fun getRandomAdvice(): Single<AdviceObject>
    fun getAdviceById(id: String): Single<AdviceObject>
}

class AdviceRemoteRepositoryImpl(private val adviceService: AdviceService) : AdviceRemoteRepository {

    override fun getRandomAdvice(): Single<AdviceObject> {
        return adviceService.getRandomAdvice()
    }

    override fun getAdviceById(id: String): Single<AdviceObject> {
        return adviceService.getAdviceById(id)
    }

}