package cn.voctrals.boot.core.validator;

import cn.voctrals.boot.core.util.ValidateUtils;
import cn.voctrals.boot.core.validator.constraints.MaxByteLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxByteLengthValidator implements ConstraintValidator<MaxByteLength, String> {

	private int max;
	
	@Override
	public void initialize(MaxByteLength constraintAnnotation) {
		this.max = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || ValidateUtils.getWordCount(value) <= this.max;
	}

//    public static int getWordCount(String s) {
//        int length = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int ascii = Character.codePointAt(s, i);
//            if (ascii >= 0 && ascii <= 255)
//                length++;
//            else
//                length += 2;
//
//        }
//        return length;
//
//    }
}
