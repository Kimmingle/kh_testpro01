package com.kh.spring.board.model.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Board;

@Repository
public class BoardRepository {

	public int boardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.boardCount");  //그룹함수들은 항상 One인듯
	}

	public List<Board> findAll(SqlSessionTemplate sqlSession, Map<String, Integer> map) {
		return sqlSession.selectList("boardMapper.findAll", map);
		//rowBounds쓸때는 selectList의 매개변수 3개짜리로 꼭 서야함 빈건 null처리
	}

	public int searchCount(SqlSessionTemplate sqlSession, Map<String, String> map) {
		return sqlSession.selectOne("boardMapper.searchCount", map);
	}

	public List<Board>findByConditionAndKetword(SqlSessionTemplate sqlSession,  Map<String, String> map, RowBounds rowBounds) {
		return sqlSession.selectList("boardMapper.findByConditionAndKetword", map, rowBounds);
	}

	public int insert(SqlSessionTemplate sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insert", board);
	}

	public int increadeCount(SqlSessionTemplate sqlSession) {
		return 0;
	}

	

}
