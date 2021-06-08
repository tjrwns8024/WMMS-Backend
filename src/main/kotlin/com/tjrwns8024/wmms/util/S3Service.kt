package com.tjrwns8024.wmms.util

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.IOException
import org.springframework.web.multipart.MultipartFile
import javax.annotation.PostConstruct


@Slf4j
@Component
class S3Service {
    lateinit var s3Client: AmazonS3

    @Value("\${cloud.aws.credentials.accessKey}")
    private val accessKey: String? = null

    @Value("\${cloud.aws.credentials.secretKey}")
    private val secretKey: String? = null

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String? = null

    @Value("\${cloud.aws.region.static}")
    private val region: String? = null

    @PostConstruct
    fun setS3Client() {
        val credentials: AWSCredentials = BasicAWSCredentials(accessKey, secretKey)
        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build()
    }

    @Throws(IOException::class)
    fun upload(file: MultipartFile, dirName: String): String? {
        val fileName = file.originalFilename
        s3Client.putObject(PutObjectRequest(bucket, dirName + fileName, file.inputStream, null)
                .withCannedAcl(CannedAccessControlList.AuthenticatedRead))
        return fileName
    }
}