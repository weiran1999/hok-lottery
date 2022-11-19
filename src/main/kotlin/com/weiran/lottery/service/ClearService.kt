package com.weiran.lottery.service

import com.weiran.lottery.common.MyResult
import com.weiran.lottery.mapper.HeroRepository
import com.weiran.lottery.mapper.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClearService {

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @Autowired
    private lateinit var heroRepository: HeroRepository

    fun clearOne(teamId: Int): MyResult {
        val result = MyResult()
        if (teamRepository.findById(teamId).isEmpty) {
            result.data = "未有查询到此队伍"
        } else {
            teamRepository.clearOneTeam(teamId)
            result.data = "清除队伍${teamId}成功"
        }
        teamRepository.clearOneTeam(teamId)
        return result
    }

    fun clearAll(): MyResult {
        val result = MyResult()
        teamRepository.clearAllTeam()
        heroRepository.clearAllHero()
        result.data = "清除全部队伍成功"
        return result
    }

}