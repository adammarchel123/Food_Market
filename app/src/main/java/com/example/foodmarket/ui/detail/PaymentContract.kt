package com.example.foodmarket.ui.detail

import android.view.View
import com.example.foodmarket.base.BasePresenter
import com.example.foodmarket.base.BaseView
import com.example.foodmarket.model.response.checkout.CheckoutResponse
import com.example.foodmarket.model.response.home.HomeResponse
import com.example.foodmarket.model.response.login.LoginResponse

interface PaymentContract {

    interface View : BaseView {
        fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: android.view.View)
        fun onCheckoutFailed(message: String)
    }

    interface Presenter : PaymentContract, BasePresenter {
        fun getCheckout(
            foodId: String,
            userId: String,
            quantity: String,
            total: String,
            view: android.view.View
        )
    }
}