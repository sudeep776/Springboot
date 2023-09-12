package com.Prep.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppError {
        private boolean success = false;
        private String errorCode;
        private String errorMessage;
        public boolean isSuccess() {
            return success;
        }
        public void setSuccess(boolean success) {
            this.success = success;
        }
        public String getErrorCode() {
            return errorCode;
        }
        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }
        public String getErrorMessage() {
            return errorMessage;
        }
        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

    }

