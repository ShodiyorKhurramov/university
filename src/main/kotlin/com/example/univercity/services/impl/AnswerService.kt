package com.example.univercity.services.impl

import com.example.univercity.payload.ApiResponse
import com.example.univercity.entities.BaseEntity
import com.example.univercity.repositories.BaseRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.validation.Errors
import java.util.*


@Service
class AnswerService {
    fun answer(message: String?, isSuccess: Boolean, id: Any?, status: HttpStatus): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(status).body(
            ApiResponse(
                message!!,
                isSuccess,
                id,
                status

            )
        )
    }


    fun <K : BaseRepository<O>, O : BaseEntity> saveObject(
        repository: K, objectEntity: O?, returnObject: Boolean
    ): HttpEntity<ApiResponse> {
        try {
            if (objectEntity != null && returnObject) {
                val savedObject = repository.save(objectEntity)
                return answer("SUCCESS", true, savedObject.id, HttpStatus.OK)
            }
            return answer("SUCCESS", true, null, HttpStatus.OK)
        } catch (e: DataIntegrityViolationException) {
            return answer("ALREADY EXISTS", false, null, HttpStatus.ALREADY_REPORTED)
        } catch (e: Exception) {
            return answer("ERROR", false, null, HttpStatus.CONFLICT)
        }
    }

    fun <K : BaseRepository<O>?, O : BaseEntity?> deleteObject(repository: K, id: Long): HttpEntity<ApiResponse> {
        return try {
            repository!!.deleteById(id)
            answer("SUCCESS", true, null, HttpStatus.OK)
        } catch (e: EmptyResultDataAccessException) {
            answer("NOT FOUND", false, null, HttpStatus.NOT_FOUND)
        } catch (e: DataIntegrityViolationException) {
            answer("USED BEFORE", false, null, HttpStatus.FORBIDDEN)
        } catch (e: Exception) {
            answer("ERROR", false, null, HttpStatus.CONFLICT)
        }
    }




}