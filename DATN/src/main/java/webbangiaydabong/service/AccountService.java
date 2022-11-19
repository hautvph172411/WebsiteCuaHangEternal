package webbangiaydabong.service;

import webbangiaydabong.dto.AccountDTO;
import webbangiaydabong.entity.Account;

public interface AccountService {
 Account findById(Long id);
 AccountDTO save (AccountDTO dto);
 Account findByEmail(String email);
 Account findByUserName(String userName);
}
