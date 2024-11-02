package space.doky.andadv2.presenter

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import space.doky.andadv2.presenter.databinding.ActivityMainBinding
import space.doky.andadv2.presenter.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SecondActivity 로 넘기는 코드
        binding.buttonStart.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // 1. 저장 버튼을 눌렀을 때:
        //   - 입력창에 있는 정보를 기기 내부에 저장한다.
        binding.buttonSave.setOnClickListener {
            val inputText = binding.inputBox.text.toString()

            lifecycleScope.launch {
                viewModel.setSampleData(inputText)
            }
        }

        // 2. 불러오기 버튼을 눌렀을 때:
        //   - 기기에 저장된 값을 텍스트 박스에 표시한다.
        binding.buttonLoad.setOnClickListener {
            lifecycleScope.launch {
                val savedValue = viewModel.getSampleData()
                binding.labelDisplay.text = savedValue
            }
        }
    }
}