package com.ovais.sadapaycasestudy.features.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ovais.sadapaycasestudy.base.BaseFragment
import com.ovais.sadapaycasestudy.databinding.FragmentGithubRepoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubRepoFragment : BaseFragment<FragmentGithubRepoBinding>() {

    private val repoViewModel: HomeViewModel by viewModels()

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentGithubRepoBinding.inflate(inflater, container, false).apply {
        viewModel = repoViewModel
        githubRepoAdapter = GithubRepoAdapter {
            repoViewModel.onItemSelected(it)
        }
        repoViewModel.onInitGithubRepositories()
    }
}