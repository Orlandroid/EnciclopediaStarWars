package com.example.androidbase.presentation.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.androidbase.R
import com.example.androidbase.presentation.alerts.MainAlert
import com.example.androidbase.presentation.alerts.MainAlert.Companion.ERROR_MESSAGE
import com.example.androidbase.presentation.ui.MainActivity


fun Fragment.showProgress() {
    (requireActivity() as MainActivity).showProgress()
}

fun Fragment.hideProgress() {
    (requireActivity() as MainActivity).hideProgress()
}

fun Fragment.shouldShowProgress(isLoading: Boolean) {
    (requireActivity() as MainActivity).shouldShowProgress(isLoading)
}


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}


fun Fragment.navigate(accion: NavDirections) {
    findNavController().navigate(accion)
}


fun Fragment.showErrorApi(shouldCloseTheViewOnApiError: Boolean = false) {
    val dialog =
        MainAlert(
            kindOfMessage = ERROR_MESSAGE,
            messageBody = getString(R.string.error_service),
            clickOnAccept = {
                if (shouldCloseTheViewOnApiError) {
                    findNavController().popBackStack()
                }
            }
        )
    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
}

fun Fragment.showErrorNetwork(shouldCloseTheViewOnApiError: Boolean = false) {
    val dialog = MainAlert(
        kindOfMessage = ERROR_MESSAGE,
        messageBody = getString(R.string.verifica_conexion),
        clickOnAccept = {
            if (shouldCloseTheViewOnApiError) {
                findNavController().popBackStack()
            }
        }
    )
    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
}


