package space.doky.andadv2.domain.interactor

//class GetDataFromRemoteStorageUseCase @Inject constructor(
//    private val firebaseRepository: FirebaseInterface,
//) {
//
//    suspend operator fun invoke(key: String): Flow<String> {
//        return firebaseRepository.start().map {
//            val map: Map<String, String> = Json.decodeFromString(JsonObject.serializer(), it)
//                .mapValues { (_, value) -> value.jsonPrimitive.contentOrNull ?: value.toString() }
//            map[key] ?: ""
//        }
//    }
//}