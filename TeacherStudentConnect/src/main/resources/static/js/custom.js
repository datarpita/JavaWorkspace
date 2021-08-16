$(document).ready(function() {

$('#liststud').click({
    "processing": true,
    "serverSide": true,
    "ajax": {
        "url": "/students",
        "type": "POST",
        "dataType": "json",
        "contentType": "application/json",
        "data": function (d) {
        	console.log('data');
        	//console.log(d)
        	var j = JSON.stringify(d);
        	console.log(j)
            return JSON.stringify(d);
        }
    },
    "columns": [
        {"data": "name", "width": "10%"},
        {"data": "gender","width": "10%"},
        {"data": "grade_level", "width": "10%"},
        {"data": "gpa", "width": "10%"},
        {"data": "notebooks", "width": "10%"},
        {"data": "activities", "width": "20%"},
        {"data": "bikedetails", "width": "15%"},
        {"data": "admissiondate", "width": "15%"}
    ]
});		
});