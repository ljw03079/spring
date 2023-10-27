package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoard(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardInfoForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : boardInsert / PARAMETER - BoardVO / RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardInfoProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		// 등록성공이든 실패이든 나중에 처리하고 안정적으로 전체조회로 돌림
		// 다시 호출 : redirect 콜론을 기준으로 앞에는 명령어 뒤에는 컨트롤러 포맷으로 알아들음.
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoard(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestBody BoardVO boardVO){
		return boardService.updateBoard(boardVO);
	}
	
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer / RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDeleteProcess(@RequestParam Integer bno,RedirectAttributes ratt) {
		int result = boardService.deleteBoard(bno);
		String msg = null;
		if(result == 1) {
			msg = "정상적으로 삭제되었습니다.";
		}else {
			msg = "정상적으로 삭제되지 않았습니다.";
		}
		ratt.addFlashAttribute("result", msg);
		return "redirect:boardList";
	}
}
