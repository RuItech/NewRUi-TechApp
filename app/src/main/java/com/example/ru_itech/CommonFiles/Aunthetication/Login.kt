package com.example.ru_itech.CommonFiles.Aunthetication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.example.ru_itech.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class Login : BaseAcivity(), View.OnClickListener {





//    declare firebase auth
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


//        val login = findViewById<Button>(R.id.Login)
//        login.setOnClickListener { startActivity(Intent(this@Login, DashBoard::class.java)) }
//
        val signupp = findViewById<TextView>(R.id.goSignupp)
        signupp.setOnClickListener{ startActivity(Intent(this,SignUp::class.java))}

//        creating onclick
//        initialize firebase auth
        auth = FirebaseAuth.getInstance()


        //        getting the complete email




//        setting onclick listenres
        Login.setOnClickListener(this)
    }



    public override fun onStart() {
        super.onStart()
//        check if user is signed in
        val currentUser = auth.currentUser
        updateUi(currentUser)
    }



    private fun signIn(email: String, password: String){
        Log.d(TAG, "signIn:$email")
        if (!validateForm()) {
            return
        }

        showProgressDialog()


//        start sign in with email
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {task ->
                    if (task.isSuccessful){
//                        sign in success update UI with the signed-in user's information
                        val user = auth.currentUser
                        Toast.makeText(baseContext,"Success",Toast.LENGTH_SHORT).show()
                        updateUi(user)

                        startActivity(Intent(this@Login,DashBoard::class.java))
//                        finish()
                    }else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        updateUi(null)
                    }

//                    start exclude
                    if (!task.isSuccessful){
//                        status.setText(R.string.auth_failed)
                    }
                    hideProgressDialog()

//                    end exclude
                }
//        end sign in with email
    }

    private fun validateForm():  Boolean{
        var valid = true

        val fnamee = fname.text.toString()
        val lnamee = lname.text.toString()

        if (TextUtils.isEmpty(fnamee)) {
            fname.error = "Required."
            valid = false
        } else if(TextUtils.isEmpty(lnamee)){
            lname.error = "Required"
            valid = false

        }else {
            fname.error = null
            lname.error = null
        }


        val password = fieldPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            fieldPassword.error = "Required."
            valid = false
        } else {
            fieldPassword.error = null
        }

        return valid
    }





    private fun updateUi(user: FirebaseUser?) {
        hideProgressDialog()

//        if (user != null){
//
//
//        }
    }

    override fun onClick(v: View) {

        val fname = fname.text.toString()
        val lname = lname.text.toString()
        val school = schoolname.text.toString()

        val email = fname + lname + school

        val i = v.id
        when (i){
            R.id.Login -> signIn(email, fieldPassword.text.toString())
//            R.id.signOutButton -> signOut()

        }

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}
