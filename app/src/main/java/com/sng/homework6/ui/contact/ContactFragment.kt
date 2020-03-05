package com.sng.homework6.ui.contact

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sng.homework6.R
import com.sng.homework6.model.Contact
import com.sng.homework6.model.ContactType
import com.sng.homework6.ui.webview.WebViewActivity
import kotlinx.android.synthetic.main.contact_fragment.*


class ContactFragment : Fragment(), ContactCallBack {

    val list: ArrayList<Contact> = arrayListOf(
        Contact(ContactType.ADD, "405S Fairfield Iowa", R.drawable.img_address, ""),
        Contact(ContactType.PHONE_NUMBER, "6418191111", R.drawable.img_call, ""),
        Contact(ContactType.MAIL, "hsnguyen@mum.edu", R.drawable.img_email, ""),
        Contact(ContactType.SOCIAL, "Son Nguyen", R.drawable.img_facebook, "https://www.facebook.com/nguyenhoangs0n")
    )

    companion object {
        fun newInstance() = ContactFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ContactRvAdapter(list, this, context)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onItemCLick(contact: Contact) {
        val nb = 42


        when (contact.type) {
            ContactType.MAIL -> {
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.data = Uri.parse("mailto:")
                emailIntent.type = "text/plain"
                emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(contact.description))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello")

                emailIntent.type = "message/rfc822"

                try {
                    startActivity(
                        Intent.createChooser(
                            emailIntent,
                            "Send email using..."
                        )
                    )
                } catch (ex: android.content.ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "No email clients installed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            ContactType.SOCIAL -> {
                val i = Intent(context, WebViewActivity::class.java)
                i.putExtra("URL", contact.url)
                startActivity(i)
            }
            ContactType.PHONE_NUMBER -> {
                val intent =
                    Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.description))
                context?.let {
                    if (ContextCompat.checkSelfPermission(
                            it,
                            CALL_PHONE
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        startActivity(intent);
                    } else {
                        requestPermissions(arrayOf(CALL_PHONE), 1);
                    }
                }
            }
            ContactType.ADD -> {

            }

        }
    }

}
