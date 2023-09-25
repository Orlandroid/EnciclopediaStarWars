package com.example.androidbase.presentation.ui.perfil

import android.content.Intent
import com.example.androidbase.R
import com.example.androidbase.data.preferences.LoginPreferences
import com.example.androidbase.databinding.FragmentPerfilBinding
import com.example.androidbase.presentation.base.BaseFragment
import com.example.androidbase.presentation.extensions.click
import com.example.androidbase.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentPerfilBinding>(R.layout.fragment_perfil) {

    @Inject
    lateinit var loginPreferences: LoginPreferences

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = getString(R.string.productos),
    )

    private val adapter = ProfileAdapter { clickOnMenu(it) }
    override fun setUpUi() {
        binding.recyclerProfile.adapter = adapter
        adapter.setData(setElementsMenu())
        binding.btnCloseSession.click {
            logOut()
        }
    }

    private fun logOut() {
        loginPreferences.destroyUserSession()
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


    private fun clickOnMenu(item: ProfileAdapter.ProfileItem) {

    }

    private fun setElementsMenu(): List<ProfileAdapter.ProfileItem> {
        val elementsMenu = arrayListOf<ProfileAdapter.ProfileItem>()
        val perfil = ProfileAdapter.ProfileItem("Perfil")
        val historial = ProfileAdapter.ProfileItem("Historial de citas")
        val contactanos = ProfileAdapter.ProfileItem("Contactanos")
        val terminos = ProfileAdapter.ProfileItem("Terminos y condiciones")
        val cerrarSesion = ProfileAdapter.ProfileItem("Cerrar sesion")
        elementsMenu.add(perfil)
        elementsMenu.add(historial)
        elementsMenu.add(contactanos)
        elementsMenu.add(terminos)
        elementsMenu.add(cerrarSesion)
        return elementsMenu
    }


}