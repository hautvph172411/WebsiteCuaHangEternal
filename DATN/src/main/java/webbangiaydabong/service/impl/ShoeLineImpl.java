package webbangiaydabong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import webbangiaydabong.entity.ShoeLine;
import webbangiaydabong.repository.ShoeLineRepository;
import webbangiaydabong.service.ShoeLineService;

import java.util.List;

@Service
public class ShoeLineImpl implements ShoeLineService {

    @Autowired
    ShoeLineRepository repository;
    @Override
    public List<ShoeLine> findAllActivce() {
        return repository.findAllActive();
    }
	@Override
	public ShoeLine find(long id) {
		return repository.findById(id).get();
	}
	@Override
	public ShoeLine create(ShoeLine shoeline) {
if(repository.existByName(shoeline.getName())) return null;
	return repository.save(shoeline);
	}
	@Override
	public void delete(long id) {
		ShoeLine updatedLine = repository.findByIdAndIsdeleteFalse(id).get();
		updatedLine.setIsdelete(true);
		 repository.save(updatedLine);
	}
	@Override
	public Page<ShoeLine> fillAll(int page, int size) {
		page = page<0? 0:page;
		Pageable pageable;
		pageable = PageRequest.of(page, size);
		return repository.findAllByIsdeleteFalse(pageable);
		
	}
	@Override
	public List<ShoeLine> search(String keyword) {
		return repository.findByNameLike("%" +keyword +"%");
	}
	@Override
	public ShoeLine update(long id, ShoeLine shoeLine) {
		if(repository.existByName(shoeLine.getName())) return null;
		ShoeLine updated = repository.findByIdAndIsdeleteFalse(id).get();
		updated.setName(shoeLine.getName());
		return repository.save(updated);
	}
}
