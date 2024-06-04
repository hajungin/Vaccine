package com.example.hospital.controller;

import com.example.hospital.dto.VaccresvDTO;
import com.example.hospital.service.MainService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/")
    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
//    루트로 들어와도 걸리고 아무것도 안 적어도 걸리고 , 스프링버전이 5 미만이면 @RequestMapping 사용을 이렇게
    public String Main(VaccresvDTO vaccresvDTO,
                       Model model){
        List<VaccresvDTO> vaccresvDTOList = mainService.findAll(vaccresvDTO);
        log.info(vaccresvDTOList.toString());
        model.addAttribute("va",vaccresvDTOList);
        return "index";
    }


    @GetMapping("/check")
    public String check(VaccresvDTO vaccresvDTO,
                        Model model){
        Long lastResvNo = mainService.findMaxResvNo();
        Long newResvNo = (lastResvNo != null) ? lastResvNo + 1 : 1L;
        vaccresvDTO.setResv_no(newResvNo);
        model.addAttribute("No",vaccresvDTO);
        return "check";
    }

    @PostMapping("/check")
    public String save(VaccresvDTO vaccresvDTO){
        log.info("=============1"+vaccresvDTO.toString());
        log.info(vaccresvDTO.getResv_time().toString());
        mainService.save(vaccresvDTO);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String show(){
        return "show";
    }

    @GetMapping("/me")
    public String showMe(@RequestParam("jumin")String jumin,@RequestParam("resv_no")Long id,

//                         @RequestParam("resv_date")LocalDateTime resv_date,
                         Model model){

            VaccresvDTO vaccresvDTO = mainService.findOne(id,jumin);


        if (vaccresvDTO != null) {
            log.info(vaccresvDTO.toString());

            // 성별 설정
            String gender = (vaccresvDTO.getJumin().charAt(7) == '1') ? "남" : "여";
            vaccresvDTO.setJumin(gender);

            // 병원 주소 설정
            String hostAddr = "";
            switch (vaccresvDTO.getHost_addr()) {
                case "10":
                    hostAddr = "서울";
                    break;
                case "20":
                    hostAddr = "대전";
                    break;
                case "30":
                    hostAddr = "대구";
                    break;
                case "40":
                    hostAddr = "광주";
                    break;
                default:
                    hostAddr = "알 수 없음";
            }
            vaccresvDTO.setHost_addr(hostAddr);

            model.addAttribute("va", vaccresvDTO);
        } else {
            log.error("vaccresvDTO is null");
            // 널인 경우에 대한 처리를 수행하세요.
            model.addAttribute("message", "예약번호 "+ id +"로 조회된 예약이 없습니다.");
        }
        model.addAttribute("va",vaccresvDTO);
        return "showMe";
    }


    @GetMapping("/detail")
    public String detail(Model model){
        List<VaccresvDTO> vaccresvDTOList = mainService.result();
        Long sum = mainService.sum();
        log.info(sum.toString());
        model.addAttribute("sum",sum);
        log.info(vaccresvDTOList.toString());
        model.addAttribute("va",vaccresvDTOList);
        return "detail";
    }

}
