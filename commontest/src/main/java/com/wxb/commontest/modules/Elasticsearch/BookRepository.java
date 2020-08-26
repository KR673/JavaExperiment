//package com.wxb.commontest.modules.Elasticsearch;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Component;
//
//public interface BookRepository extends ElasticsearchRepository<BookBean, String> {
//
//    //Optional<BookBean> findById(String id);
//    Page<BookBean> findByAuthor(String author, Pageable pageable);
//
//    Page<BookBean> findByTitle(String title, Pageable pageable);
//
//}
//
