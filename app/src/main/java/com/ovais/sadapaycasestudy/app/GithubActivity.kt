package com.ovais.sadapaycasestudy.app

import com.ovais.sadapaycasestudy.R
import com.ovais.sadapaycasestudy.base.BaseActivity
import com.ovais.sadapaycasestudy.databinding.ActivityGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubActivity : BaseActivity<ActivityGithubBinding>() {

    override fun getLayout(): Int = R.layout.activity_github
}