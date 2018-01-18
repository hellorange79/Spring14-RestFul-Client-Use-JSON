package json.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.Search;

import spring.domain.UserHasASearch;

public class UserHasASearchObjectMapperTestApp {

	public static void main(String[] args)throws Exception {
		
		UserHasASearch userHasASearch= new UserHasASearch("usr01","홍길동","1111",null,10);
		
		Search search= new Search();
		search.setSearchCondition("이름검색");
		userHasASearch.setSearch(search);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		System.out.println("\n\n///////////////////////////////////////////");
		System.out.println("1. domain object -> jsno value (String)으로 변환");
		String jsonValue = objectMapper.writeValueAsString(userHasASearch);
		System.out.println(jsonValue);
		
		System.out.println();
		
		System.out.println("1. json value -> jsno value (String)으로 변환");
		System.out.println("1. JSON Value => Domain Object 변환 및 값 추출");
		UserHasASearch returnuserHasASearch =objectMapper.readValue(jsonValue, UserHasASearch.class);
		System.out.println(returnuserHasASearch);
		System.out.println("userId : "+returnuserHasASearch.getUserId());
		System.out.println("SearchCondition : "+returnuserHasASearch.getSearch().getSearchCondition());
		
		System.out.println();
		
		System.out.println("1. JSON Value==>JSONObject 변환 및 값 추출");
		JSONObject jsonObject=(JSONObject)JSONValue.parse(jsonValue);
		System.out.println(jsonValue);
		System.out.println("userId : "+jsonObject.get("userId"));
		System.out.println("searchCondition : "+((JSONObject)
				(jsonObject.get("search"))).get("searchConditon"));

	}

}
