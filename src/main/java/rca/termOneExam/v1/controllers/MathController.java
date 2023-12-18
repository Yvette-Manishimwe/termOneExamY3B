package rca.termOneExam.v1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.termOneExam.v1.dtos.DoMathRequestDto;
import rca.termOneExam.v1.exceptions.InvalidOperationException;
import rca.termOneExam.v1.payload.ApiResponse;
import rca.termOneExam.v1.serviceImpls.MathOperatorImpl;

@RestController
@RequestMapping("/api/do_math")
public class MathController {
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getNum1(), dto.getNum2(), dto.getOperation())));
    }
}
