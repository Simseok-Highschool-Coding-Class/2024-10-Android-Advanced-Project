package space.doky.andadv2.presenter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
//    private val getDataFromRemoteStorageUseCase: GetDataFromRemoteStorageUseCase,
//    private val setDataToRemoteStorageUseCase: SetDataToRemoteStorageUseCase,
): ViewModel() {

    suspend fun getSampleData(): String {

        // === 작동되지 않음 ===

        // 웹에서 sample_web_data 키로 String 값을 가져옴
        //  * 아쉽게도.. String 이외의 다른 타입으로 값을 저장하거나 가져올 수 없습니다 ㅠ

        // val data = getDataFromRemoteStorageUseCase("sample_web_data").firstOrNull()
        //
        // if (data == null) {
        //     return ""
        // } else {
        //     return data
        // }
        return ""
    }

    suspend fun setSampleData(value: String) {

        // === 작동되지 않음 ===

        // 웹에다가 sample_web_data 키로 String을 저장하는 코드
        // setDataToRemoteStorageUseCase("sample_web_data", value)
    }
}
