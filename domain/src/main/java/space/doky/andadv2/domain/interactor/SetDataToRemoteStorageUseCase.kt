package space.doky.andadv2.domain.interactor

//class SetDataToRemoteStorageUseCase @Inject constructor(
//    private val firebaseRepository: FirebaseInterface,
//) {
//    suspend operator fun invoke(key: String, value: String) {
//
//        AppLog.e("============", "inv", "start")
//
//        val listRaw = firebaseRepository.start().firstOrNull() ?: ""
//
//        AppLog.e("============", "inv", "listRaw: $listRaw")
//
//        val map = Json.decodeFromString(JsonObject.serializer(), listRaw)
//            .mapValues { (_, value) -> value.jsonPrimitive.contentOrNull ?: value.toString() }.toMutableMap()
//        map[key] = value
//
//        AppLog.e("============", "inv", "map: $map")
//
//        val jsonString = Json.encodeToString(MapSerializer(String.serializer(), String.serializer()), map)
//        firebaseRepository.sendData(jsonString)
//    }
//}