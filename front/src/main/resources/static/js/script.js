let all_faq = document.querySelectorAll('.notes-overflowed');

all_faq.forEach((item,key)=>{
    item.addEventListener('click',()=>{
        item.classList.toggle('active');
    })
})