package com.sseugssag.main.review;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sseugssag.main.SiteOption;
import com.sseugssag.main.login.Customer;

@Service
public class ReviewDAO {
	private int allReviewCount;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	//이 함수 쓰기 전에 tokenMaker 만들기
	public void writeReview(Review r, HttpServletRequest req){
		try {
			String token = req.getParameter("token");
			String st2 = (String)req.getSession().getAttribute("st");
			
		 
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글 등록 실패(새로 고침)");
				return;
			}
			
			//로그인한 사람의 정보 가지고 오기	
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr  = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());

			Customer m = (Customer)req.getSession().getAttribute("loginCustomer");
			r.setC_id(m.getC_id());
			
			String r_photo = mr.getFilesystemName("r_photo");
			if (r_photo !=null) {
				String r_photo_kor = URLEncoder.encode(r_photo, "utf-8").replace("+", " ");
				r.setR_photo(r_photo_kor);
				
			}
			
			
			//별점 관련 식
			//BigDecimal star = new BigDecimal(mr.getParameter("r_star"));
			
			r.setR_star(mr.getParameter("r_star"));
//			public void getStar(HttpServletRequest req) {
//				return new Reviews(ss.getMapper(ReviewMapper.class).checkStar());
//			}
			
			//별점 등록 부분?
//			try {
//				String star = mr.getFilesystemName("r_star");
//				if (ss.getMapper(ReviewMapper.class).checkStar(r)==1) {
//					if (star.equals("1") ) {
//						req.setAttribute("star", "★☆☆☆☆");					
//					}else if (star.equals("2")) {
//						req.setAttribute("star", "★★☆☆☆");
//					} else if (star.equals("3")) {
//						req.setAttribute("star", "★★★☆☆");
//					} else if (star.equals("4")) {
//						req.setAttribute("star", "★★★★☆");
//					} else {
//						req.setAttribute("star", "★★★★★");
//					}
//					
//				}
//				
//			} catch (Exception e) {
//				req.setAttribute("star", "별점 등록 실패");
//			
//			}
			

		
			//String r_txt = mr.getFilesystemName("r_txt");
			r.setR_txt(mr.getParameter("r_txt").replace("\r\n", "<br>"));
			//r_txt = r.getR_txt().replace("\r\n", "<br>");
			//r.setR_txt(r_txt);
			
			
			
			if (ss.getMapper(ReviewMapper.class).writeReview(r)==1) {
				req.setAttribute("r", "글이 등록되었습니다");
				req.getSession().setAttribute("st", token);
				allReviewCount++; //리뷰가 하나씩 추가되도록
			}else {
				req.setAttribute("r", "글 등록 실패1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글 등록 실패2");
		}
	}
	

	public void countReview() {
		//ReviewMapper의 페이지 세는 것과 연결
		allReviewCount = ss.getMapper(ReviewMapper.class).getAllReviewCount();
		
	}
	
	//페이지 관련 식
	public void getReviewPage(int page, HttpServletRequest req) {
		//pageNo라고 쓰인 곳에 parameter로 받은 page 넣기
		req.setAttribute("pageNo", page);
		
		//검색
		String search = (String)req.getSession().getAttribute("search");
		int rvCount = 0;
		if (search == null) { //검색을 하나도 하지 않은 상황 ->전체조회
			rvCount = allReviewCount;
			search = ""; //빈칸으로 둔다
		}else { //검색어가 있는 상황 -> 검색한 것만 나오게
			//myBatis로 넘어가서 select문 작성
			ReviewSelector rs = new ReviewSelector(search, 0, 0); //int라서 0
			rvCount = ss.getMapper(ReviewMapper.class).getSearchRvCount(rs);
		}
		
		//페이지 나누기
		so.setRvPerPage(10);
		int allPageCount = (int)Math.ceil((double)rvCount/so.getRvPerPage());
		req.setAttribute("allPageCount", allPageCount);
		//시작, 끝 페이지
		int start = (page-1)*so.getRvPerPage() +1;
		int end = (page == allPageCount)? rvCount: (start+so.getRvPerPage()-1);
		ReviewSelector rsel = new ReviewSelector(search, start, end);
		//review자바빈이 담긴 list를 꺼내서 검색어 기준으로 모든 정보를 꺼내온다-myBatis로 간다
		List<Review> rv = ss.getMapper(ReviewMapper.class).getRv(rsel);
		req.setAttribute("rv", rv);
	}
	
	//검색어 없애기
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	//검색어 찾기
	public void searchRv(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	
	//게시글 삭제하기
	public void deleteRv(Review r, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReviewMapper.class).deleteRv(r)==1) {
				req.setAttribute("r", "글이 성공적으로 삭제되었습니다");
				allReviewCount--;
			}else {
				req.setAttribute("r", "글 삭제 실패");
			}
		} catch (Exception e) {
				req.setAttribute("r", "글 삭제 실패 2");
		}
	}
	
	//게시글 수정하기
	public void updateRv(Review r, HttpServletRequest req) {
		try {
			if (ss.getMapper(ReviewMapper.class).updateRv(r)==1) {
				req.setAttribute("r", "글이 수정되었습니다.");
			}else {
				req.setAttribute("r", "글 수정 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글 수정 실패");
		}
	}
	
}
