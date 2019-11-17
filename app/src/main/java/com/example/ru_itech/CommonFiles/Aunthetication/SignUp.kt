package com.example.ru_itech.CommonFiles.Aunthetication

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.ru_itech.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.fname

import kotlinx.android.synthetic.main.activity_login.lname
import kotlinx.android.synthetic.main.activity_login.schoolname
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.fieldPassword as fieldPassword1

class SignUp : BaseAcivity(), View.OnClickListener {




    // [START declare_auth]
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val logg = findViewById<TextView>(R.id.goLogInn)
//        log.setOnClickListener{startActivity(Intent(this,Login::class.java))}

        logg.setOnClickListener{ startActivity(Intent(this,com.example.ru_itech.CommonFiles.Aunthetication.Login::class.java))}


        auth = FirebaseAuth.getInstance()

        goSignup.setOnClickListener(this)

    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUi(currentUser)
    }


    private fun validateForm(): Boolean {

        var valid = true

        var fnamee = fname.text.toString()
        var lnamee = lname.text.toString()
        var passwordd = fieldPassword.text.toString()
        val checkboxx = checkbox.text.toString()

        if (TextUtils.isEmpty(fnamee)){
            fname.setError("Required")
        }else if (TextUtils.isEmpty(lnamee)){
            lname.setError("Required")
        }else if (TextUtils.isEmpty(passwordd)){
            fieldPassword.setError("Required")
        }else if(TextUtils.isEmpty(checkboxx)){
            checkbox.setError("Agree to terms and conditions")
        }



        else{
            fname.error = null
            lname.error = null
            fieldPassword.error = null
            checkbox.error = null
        }

        return valid
    }


    private fun createAccount(email: String, password: String){
        Log.d(TAG, "create Account $email")

        if (!validateForm()){
            return
        }

        showProgressDialog()
//        start create user with email

        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {task ->
                    if (task.isSuccessful){
                        Log.d(TAG, "create user with email and pass: success")
                        val user = auth.currentUser
                        updateUi(user)

                        startActivity(Intent(this,DashBoard::class.java))

                    }else{
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext,"Authentication failed.",Toast.LENGTH_SHORT).show()

                        updateUi(null)
                    }
                    hideProgressDialog()

                }

        }






    private fun updateUi(user: FirebaseUser?) {

    }

    override fun onClick(v: View) {

        val fname = fname.text.toString()
        val lname = lname.text.toString()
        val school = schoolname.text.toString()

        val email = fname + lname + school

        val i = v.id
        if (checkbox.isChecked){
        when (i){
            R.id.goSignup -> createAccount(email,fieldPassword.text.toString())
        }
        }else{
            Toast.makeText(baseContext,"Agree to terms and conditions",Toast.LENGTH_SHORT).show()
        }

    }


    companion object {
        private const val TAG = "EmailPassword"
    }
}
