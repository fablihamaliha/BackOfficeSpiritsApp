package com.cgi.test.service;

public class OrderServiceTest {
	
//private List<Blog> bloglist;
//	
//	@Autowired
//	MockMvc mockmvc;
//	
//	@InjectMocks
//	BlogRepository blogreposer;
//	
//	@MockBean
//	BlogServiceImpl blogserctl;
//	
//	//@Mock
//	//private BlogRepository blogRepository;
//
//
//
////	@InjectMocks
////	private BlogServiceImpl blogService;
////	private Blog blog,blog1;
////	private List<Blog> blogList;
////	private Optional optional;
//	
//	
//	Blog blog1;
//	Blog blog2;
//	
//	@Test
//	public void setUp()
//	{
//		MockitoAnnotations.initMocks(this);
//		
//		mockmvc = MockMvcBuilders.standaloneSetup(blogserctl).build();
//		
//		bloglist = new ArrayList<Blog>();
//		
//		blog1 = new Blog(1,"title1","author2","content1");
//		blog2 = new Blog(2,"title2","author2","content2");
//		bloglist.add(blog1);
//		bloglist.add(blog2);
//	//	Optional<?> optional = Optional.of(blog1);
//		
//		
//		
//	}
//	@Test
//	public void testsaveBlog() throws Exception{
//		
//		Mockito.when(blogreposer.save(any())).thenReturn(blog1);
//
//		assertEquals(blog1, blogserctl.saveBlog(blog1));
//
//		verify(blogreposer, times(1)).save(any());
//
//
//		
//	}
//	
//	
////	@Test
////	public void SaveBlogSuccess() {
////	when(blogRepository.save(any())).thenReturn(blog);
////	assertEquals(blog, blogService.saveBlog(blog));
////	verify(blogRepository, times(1)).save(any());
////	}
//
//
//	
//	public void testgetAllBlog() throws Exception {
//		Mockito.when(blogreposer.findAll()).thenReturn(bloglist);
//
//		assertEquals(bloglist, blogserctl.getAllBlogs());
//
//		verify(blogreposer, times(1)).findAll();
//		
//	}
//	@Test
//	public void testdeleteblogSuccess() throws Exception {
//		Optional<Blog> optional = Optional.of(blog1);
//		Mockito.when(blogreposer.findById(blog1.getBlogId())).thenReturn(optional);
//		Blog delblog = blogserctl.deleteBlog(1);
//		
//		assertEquals(1, delblog.getBlogId());
//		
//
//		
//		
//		verify(blogreposer, times(2)).findById(blog1.getBlogId());
//		verify(blogreposer, times(1)).deleteById(blog1.getBlogId());
//
//	}
//	
//	public void testupdateblogSuccess() throws Exception {
//		Optional<Blog> optional = Optional.of(blog1);
//		Mockito.when(blogreposer.findById(blog1.getBlogId())).thenReturn(optional);
//		Mockito.when(blogreposer.save(blog1)).thenReturn(blog1);
//		
//		Blog blogobj = blogserctl.updateBlog(blog1);
//
//		assertEquals(blogobj, blogserctl.updateBlog(blog1));
//
//		verify(blogreposer, times(1)).save(any());
//		verify(blogreposer, times(2)).findById(blog1.getBlogId());
//
//		
//	}

}
