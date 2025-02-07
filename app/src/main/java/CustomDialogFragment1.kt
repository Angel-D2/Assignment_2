import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.MainActivity2
import com.example.dialogfragment.R

class CustomDialogFragment1: DialogFragment(R.layout.fragment_custom_dialog1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.cancelBT);
        val submitbt : Button = view.findViewById(R.id.submitBT);
        val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancelbt.setOnClickListener{
            dismiss()
        }
        submitbt.setOnClickListener {
            val selectedOption: Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context,radioButton.text,Toast.LENGTH_SHORT).show()
            val m1: MainActivity2 = getActivity() as MainActivity2;
            m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }
}
