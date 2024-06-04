function change() {
        var selectBox = document.getElementById("number");
        var selectedValue = selectBox.options[selectBox.selectedIndex].value;

        if (selectedValue === "n1") {
            document.getElementById("resv_no_div").style.display = "block";
            document.getElementById("jumin_div").style.display = "none";
            document.getElementById("resv_date_div").style.display = "none";
        } else if (selectedValue === "n2") {
            document.getElementById("resv_no_div").style.display = "none";
            document.getElementById("jumin_div").style.display = "block";
            document.getElementById("resv_date_div").style.display = "none";
        } else if (selectedValue === "n3") {
            document.getElementById("resv_no_div").style.display = "none";
            document.getElementById("jumin_div").style.display = "none";
            document.getElementById("resv_date_div").style.display = "block";
        }
    }