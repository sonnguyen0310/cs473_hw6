package com.sng.homework6.ui.contact

import com.sng.homework6.model.Contact

interface ContactCallBack {
    fun onItemCLick(contact: Contact)
}