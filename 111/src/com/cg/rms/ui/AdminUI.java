package com.cg.rms.ui;

import com.cg.rms.exception.RecruitmentException;

public interface AdminUI {
    public void showAdminMenu(String id) throws RecruitmentException;
	void countpcmonth(String month);
	void countpccompany(String Company);
	void countpcposition(String designation);
}
