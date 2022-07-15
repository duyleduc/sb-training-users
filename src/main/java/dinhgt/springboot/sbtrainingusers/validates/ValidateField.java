package dinhgt.springboot.sbtrainingusers.validates;

import dinhgt.springboot.sbtrainingusers.controllers.AccountRestException;

public class ValidateField {

	public static boolean checkName(String name) {
		name = name.trim();
		if (name.isEmpty()) {
			throw new AccountRestException("one or more fields have an error. please check and try again");
		}
		if (name.length() > 64) {
			throw new AccountRestException("one or more fields have an error. please check and try again");
		}
		return true;

	}

	public static boolean checkEmail(String email) {
		if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
			throw new AccountRestException("one or more fields have an error. please check and try again");
		return true;
	}

	public static boolean checkPhoneNumber(String phone) {
		if (!phone.matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$"))
			throw new AccountRestException("one or more fields have an error. please check and try again");
		return true;
	}

}
