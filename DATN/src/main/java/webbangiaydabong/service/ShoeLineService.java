package webbangiaydabong.service;

import webbangiaydabong.entity.ShoeLine;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ShoeLineService {
    List<ShoeLine> findAllActivce();
    ShoeLine find(long id);
    ShoeLine create(ShoeLine shoeline);
    ShoeLine update(long id,ShoeLine shoeLine);
    void delete(long id);
    Page<ShoeLine> fillAll(int page , int size);
    List<ShoeLine> search(String keyword);
    
}
