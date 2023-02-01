package webbangiaydabong.Rest;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webbangiaydabong.entity.ShoeLine;
import webbangiaydabong.service.ShoeLineService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/shoelines")
public class ShoeLineRestController {
	@Autowired
	ShoeLineService shoelineService;

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody ShoeLine shoeLine) {
		ShoeLine shoeLines = shoelineService.create(shoeLine);
		if (shoeLines == null) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(shoeLines, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ShoeLine request) {
		ShoeLine shoeline = shoelineService.update(id, request);
		if (shoeline == null) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(shoeline, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			shoelineService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping()
	public ResponseEntity<?> getAll(@RequestParam("page") int page,
									@RequestParam("size") int size) {
		Page<ShoeLine> shoeLine = shoelineService.fillAll(page, size);
		if (shoeLine.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(shoeLine, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		ShoeLine sole = shoelineService.find(id);
		if (sole == null) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(sole, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam("keyword") String keyword) {
		List<ShoeLine> shoeLine = shoelineService.search(keyword);
		if (shoeLine.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(shoeLine, HttpStatus.OK);
	}

}
